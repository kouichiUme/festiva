package nagoya.code4.hojin;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author kouichi
 *
 */
public class HojinBaseInfo {

	public static final String HoujinBaseInfomation = "法人基本情報";

	/**
	 * 法人番号 法人の法人番号。 13 桁の数値を文字列として表記したもの
	 * 
	 * xsd:string
	 */
	@JsonProperty("ic:ID/ic:識別値")
	private String id;

	/**
	 * 商号又は名称の種別 法人の商号又は名称 (ic:名称/ic:表記) の種別を明示したもの。「商号」や「企業名」 などといった値をとる。
	 * xsd:string
	 */
	@JsonProperty("ic:名称/ic:種別")
	private String name;

	/**
	 * 
	 * 商号又は名称 法人の商号又は名称。xsd:string
	 */
	@JsonProperty("ic:名称/ic:表記 ")
	private String hyouki;

	/**
	 * 活動状況の発生日
	 * 
	 * 法人の活動状況 (ic:活動状況/ic:説明) が発生した日時。W3C XML Schema の dateTime 型として定められる
	 * YYYY-MM-DDThh:mm:ss 型の表記をとる。 xsd:dateTime
	 */
	@JsonProperty("ic:活動状況/ic:発生日/ic:標準型日時")
	private Date date;

	/**
	 * ic:活動状況/ic:説明
	 */
	@JsonProperty("ic:活動状況/ic:説明")
	private String description;

	/**
	 * 国内所在地の種別 法人の所在地 (ic:住所/ic:表記) の種別を明示したもの xsd:string
	 */
	@JsonProperty("ic:住所/ic:種別")
	private String access;

	/**
	 * 国内所在地（全文表記）
	 * 法人の所在地の全文表記（都道府県や市区町村などのまとまりで区切らずに、一続 きの文字列として表現したもの）。
	 * xsd:string
	 */
	@JsonProperty("ic:住所/ic:表記")
	private String address;
	
	/**
	 * 
	 * 郵便番号
	 * 法人の所在地に対応する郵便番号。
	 * xsd:string
	 * 
	 */
	@JsonProperty("ic:住所/ic:郵便番号")
	private String postCode;
	
	

}
