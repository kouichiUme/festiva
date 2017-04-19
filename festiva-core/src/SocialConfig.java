

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.UserIdSource;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SocialAuthenticationProvider;
import org.springframework.social.security.SocialAuthenticationServiceLocator;
import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ImportResource(value = { "classpath:core-context.xml"})
@PropertySource("classpath:")
@Configuration
public class SocialConfig extends WebMvcConfigurerAdapter  {

	@Autowired
	private Environment environment;

	@Autowired
	private DataSource dataSource;

	@Bean
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(environment
				.getProperty("oauth.appId"), environment
				.getProperty("oauth.appSecret")));
		return registry;
	}

	@Bean
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
	public SocialAuthenticationServiceLocator socialAuthenticationServiceLocator() {
		SocialAuthenticationServiceRegistry registry = new SocialAuthenticationServiceRegistry();
		registry.addConnectionFactory(new FacebookConnectionFactory(environment
				.getProperty("oauth.appId"), environment.getProperty("oauth.appSecret")));
		return registry;
	}

	@Bean
	@Scope(value = "singleton", proxyMode = ScopedProxyMode.INTERFACES)
	public UsersConnectionRepository usersConnectionRepository() {
		return new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator(), Encryptors.noOpText());
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException(
					"Unable to get a ConnectionRepository: no user signed in");
		}
		return usersConnectionRepository().createConnectionRepository(
				authentication.getName());

	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public Facebook facebook() {
		return connectionRepository().getPrimaryConnection(Facebook.class)
				.getApi();
	}

	@Bean
	public ProviderSignInController providerSignInController(
			RequestCache requestCache) {
		return new ProviderSignInController(connectionFactoryLocator(),
				usersConnectionRepository(), new SimpleSignInAdapter(
						requestCache));
	}

	@Bean
	public ConnectController connectController() {
		ConnectController controller = new ConnectController(
				connectionFactoryLocator(), connectionRepository());
		return controller;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}

	@Bean
	public SocialAuthenticationFilter socialAuthenticationFilter(
			AuthenticationManager authenticationManager,
			RememberMeServices rememberMeServices,
			SocialAuthenticationServiceLocator authenticationServiceLocator) {
		SocialAuthenticationFilter socialAuthenticationFilter = new SocialAuthenticationFilter(
				authenticationManager, userIdSource(),
				usersConnectionRepository(), authenticationServiceLocator);
		socialAuthenticationFilter.setSignupUrl("/signup"); // TODO:
																		// Fix
																		// filter
																		// to
																		// handle
																		// in-app
																		// paths
		socialAuthenticationFilter.setRememberMeServices(rememberMeServices);
		return socialAuthenticationFilter;
	}

	@Bean
	public AuthenticationProvider socialAuthenticationProvider(
			UserDetailsService userDetailsService) {
		return new SocialAuthenticationProvider(usersConnectionRepository(),
				socialUsersDetailsService(userDetailsService));
	}

	@Bean
	public SocialUserDetailsService socialUsersDetailsService(
			UserDetailsService userDetailsService) {
		return new SimpleSocialUsersDetailService(userDetailsService);
	}

	@Bean
	public UserIdSource userIdSource() {
		return new AuthenticationUserIdExtractor();
	}

}
