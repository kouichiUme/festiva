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
	 * 国内所在地（全文表記） 法人の所在地の全文表記（都道府県や市区町村などのまとまりで区切らずに、一続 きの文字列として表現したもの）。
	 * xsd:string
	 */
	@JsonProperty("ic:住所/ic:表記")
	private String address;

	/**
	 * 
	 * 郵便番号 法人の所在地に対応する郵便番号。 xsd:string
	 * 
	 */
	@JsonProperty("ic:住所/ic:郵便番号")
	private String postCode;

	/**
	 * 国内所在地（都道府県） 住所/ic:都道府県 xsd:string 法
	 */
	@JsonProperty("ic:住所/ic:都道府県")
	private String prefName;

	/**
	 * 都道府県コード ic:住所/ic:都道府県コード
	 * 
	 * ic:コード型
	 * 
	 * 
	 */
	@JsonProperty("ic:住所/ic:都道府県コード")
	private String prefCode;

	/**
	 * 国内所在地（市区町村） ic:住所/ic:市区町村 xsd:string
	 * 
	 */
	@JsonProperty("ic:住所/ic:市区町村")
	private String cityName;

	/**
	 * 国内所在地（市区町村） ic:住所/ic:市区町村コード ic:コード型
	 * 
	 * 
	 */
	@JsonProperty("ic:住所/ic:市区町村コード")
	private String cityCode;

	/**
	 * 国内所在地（丁目番地等）
	 * 
	 * 
	 * ic:住所/hj:丁目番地等 xsd:string
	 */
	@JsonProperty("ic:住所/hj:丁目番地等")
	private String banchi;

	/**
	 * 法人種別
	 * 
	 * 101 国の機関 値「101」は、行政機関、裁判所及び国会の機関に係る情報であることを意味 する。 201 地方公共 団体
	 * 値「201」は、地方自治法第１条の３において定義されている普通地方公共団 体及び特別地方公共団体に係る情報であることを意味する。 301 株式会社
	 * 値「301」は、株式会社の情報であることを意味する。 302 有限会社 値「302」は、特例有限会社の情報であることを意味する。 303 合名会社
	 * 値「303」は、合名会社の情報であることを意味する。 304 合資会社 値「304」は、合資会社の情報であることを意味する。 305 合同会社
	 * 値「305」は、合同会社の情報であることを意味する 399 その他の設立登記法人
	 * 値「399」は、株式会社（301）、有限会社（302）、合名会社（303）、合資会社
	 * （304）及び合同会社（305）以外の法令の規定により設立の登記をすることに よって成立する法人の情報であることを意味する。
	 * 
	 * 401 外国会社等 値「401」は、外国、外国の行政区画及び外国会社並びに法律又は条約の規 定により認許された外国法人の情報であることを意味する。
	 * 499 その他 上記以外の人格のない社団等及び日本の法律の規定により成立し、設立の 登記を行わない法人の情報であることを意味する。 ic:組織種別
	 * ic:コード型
	 */
	@JsonProperty("ic:組織種別")
	private String kind;

	/**
	 * 
	 * 更新年月日 xsd:dateTime
	 */
	@JsonProperty("hj:更新日時/ic:標準型日時")
	private Date updateTime;

	/**
	 * 公表組織の法人番号の種別 法人基本情報の提供元である組織の法人番号の種別を明示したもの。
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:体系/ic:名称/ic:表記")
	private String houjinKind;

	/**
	 * 発行組織の名称 法人基本情報の発行元である組織の名称。
	 * 
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:体系/ic:発行者/ic:名称/ic:表記")
	private String meisyou;

	/**
	 * 公表組織の法人番号
	 * 
	 * 法人基本情報の提供元である組織の法人番号。 xsd:string
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:識別値")
	private String kouhyousosikiId;

	/**
	 * 公表組織の名称 法人基本情報の提供元である組織の名称。
	 * 
	 * xsd:string
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:名称/ic:表記 ")
	private String kouhyousosikiHyouki;

	/**
	 * 区分情報の種別
	 * 
	 * 法人基本情報の区分情報の種別を表す文字列。「処理」または「訂正」などが用いられる。
	 * 
	 * xsd:string
	 */
	@JsonProperty("hj:区分/ic:種別")
	private String kubunSyubetu;
	
	/**
	 * 区分情報の表記
	 * hj:区分/ic:表記
	 * xsd:string
	 */
	@JsonProperty("hj:区分/ic:表記")
	private String kubunHyouki;

}
