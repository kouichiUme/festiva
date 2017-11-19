package nagoya.code4.hojin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoujinHojyokin {

	/**
	 * ic:ID/ic:識別値
	 *
	 * 法人番号 補助金の交付先となる法人の法人番号。13 桁の数値を文字列として表記したもの。
	 * 
	 * xsd:string
	 */
	@JsonProperty("ic:ID/ic:識別値")
	private String id;

	/**
	 * 交付先名の種別
	 * 
	 * 
	 * ic:名称/ic:種別
	 * 
	 * xsd:string
	 */
	@JsonProperty("ic:名称/ic:種別")
	private String name;

	/**
	 * 交付先名
	 * 
	 * ic:名称/ic:表記
	 */
	@JsonProperty("ic:名称/ic:表記")
	private String hyouki;

	/**
	 * 
	 * 交付先名のカナ表記
	 * 
	 */
	@JsonProperty("ic:名称/ic:カナ表記")
	private String koufusakiKana;

	/**
	 * 
	 * 交付先の連絡先の種別
	 * 
	 * 
	 */
	@JsonProperty("ic:連絡先/ic:種別")
	private String koufusakiRenrakusaki;

	/**
	 * 交付先の電話番号
	 */
	@JsonProperty("ic:連絡先/ic:電話番号")
	private String koufusakiSyubetu;

	/**
	 * 交付先の FAX 番号
	 * 
	 */
	@JsonProperty("ic:連絡先/ic:FAX 番号")
	private String renrakusakiFax;

	/**
	 * 関連組織の役割
	 */
	@JsonProperty("ic:関連組織/ic:役割")
	private String kannrennsosikinoyakuwari;

	/**
	 * 関連組織の名称
	 * 
	 * 関連する組織 (ic:関連組織/ic:組織) が具体的にどのような関係にあるかを記載したも の。「本店」や「支店」など。
	 * 
	 * 
	 */
	@JsonProperty("ic:関連組織/ic:組織/ic:名称/ic:表記")
	private String aaa;

	/**
	 * 関連組織の名称
	 * 
	 * 補助金の交付先となる法人に関連する、別の組織 (本店や支店など) の名称。
	 * 
	 * ic:住所/ic:種別
	 */
	@JsonProperty("ic:住所/ic:種別")
	private String bbb;

	/**
	 * 国内所在地（全文表記）
	 * 
	 * ic:住所/ic:表記
	 */
	@JsonProperty("ic:住所/ic:表記")
	private String ccc;

	/**
	 * 国内所在地（都道府県）ic:住所/ic:都道府県
	 * 
	 */
	@JsonProperty("ic:住所/ic:郵便番号")
	private String ddd;

	/**
	 * ic:住所/ic:都道府県
	 * 
	 * 補助金の交付先となる法人の所在する都道府県。
	 * 
	 */
	@JsonProperty("ic:住所/ic:都道府県")
	private String eee;

	/**
	 * 
	 * 
	 * 国内所在地（市区町村）
	 */
	@JsonProperty("ic:住所/ic:市区町村")
	private String fff;

	/**
	 * 国内所在地（丁目番地等）
	 * 
	 * 法人の所在地の内、「都道府県」「市区町村」に続く部分を抜き出したもの。
	 */
	@JsonProperty("ic:住所/hj:丁目番地等")
	private String aaaaaaa;

	/**
	 * 代表者役割
	 */
	@JsonProperty("ic:代表者/ic:役割")
	private String ddddddd;

	/**
	 * 
	 */
	@JsonProperty("ic:代表者/ic:構成員/ic:氏名/ic:種別")
	private String dddddddd;

	/**
	 * 
	 * 代表者名
	 * 
	 * 補助金の交付先となる法人の代表者の姓名。
	 */
	@JsonProperty("ic:代表者/ic:構成員/ic:氏名/ic:姓名")
	private String eee1;

	/**
	 * 
	 */
	@JsonProperty("ic:設立日/ic:標準型日付")
	private String eee12;

	/***
	 * 
	 * 資本金
	 * 
	 * 補助金の交付先となる法人の資本金。
	 * 
	 */
	@JsonProperty("ic:資本金/ic:数値")
	private String eee13;
	/***
	 * 
	 * 資本金の通貨単位
	 * 
	 * 補助金の交付先となる法人の資本金の通貨単位。「円」や「ドル」など。
	 * 
	 */
	@JsonProperty("ic:資本金/ic:通貨")
	private String eee14;

	/***
	 * 資本金の通貨単位 (コード表記)
	 * 
	 * 補助金の交付先となる法人の資本金の通貨単位。「円」や「ドル」など。
	 * 
	 */
	@JsonProperty("ic:資本金/ic:通貨コード")
	private String eee15;

	/**
	 * 従業員数 補助金の交付先となる法人の従業員数。
	 * 
	 */
	@JsonProperty("ic:関連人員/ic:人数")
	private String eee16;

	/**
	 * 更新年月日
	 * 
	 * 補助金情報の更新日時。W3C XML Schema の dateTime 型として定められる YYYY-MM-DDThh:mm:ss
	 * 型の表記をとる。
	 * 
	 */
	@JsonProperty("hj:更新日時/ic:標準型日時")
	private String eee17;

	/**
	 * 公表組織の法人番号の種別
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:体系/ic:名称/ic:表記")
	private String eee18;
	
	/**
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:体系/ic:発行者/ic:名称/ic:表記")
	private String eee19;
	/**
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:ID/ic:識別値")
	private String eee20;
	
	/**
	 * 
	 */
	@JsonProperty("hj:公表組織/ic:名称/ic:表記")
	private String eee21;
	
	/***
	 * 
	 */
	@JsonProperty("hj:システム名/ic:表記")
	private String eee22;
	
	/**
	 * 
	 * 
	 */
	
	@JsonProperty("hj:キー情報")
	private String eee23;
	
	/**
	 * 
	 */
	@JsonProperty("hj:業種コード")
	private String eee24;
	

	@JsonProperty("hj:事業内容")
	private String eee25;
	
	
	@JsonProperty("hj:営業エリア/ic:名称/ic:表記")
	private String eee26;
	
	@JsonProperty("hj:決算情報/ic:金額/ic:数値")
	private String eee27;
	
	
	@JsonProperty("hj:決算情報/ic:金額/ic:通貨")
	private String eee28;
	
	
	@JsonProperty("hj:決算情報/ic:金額/ic:通貨コード")
	private String eee29;
	
	@JsonProperty("hj:認定日/ic:標準型日付")
	private String eee3;
	
	@JsonProperty("hj:活動名称/ic:表記")
	private String eee4;
	
	
	@JsonProperty("hj:部門")
	private String eee5;

	@JsonProperty("hj:区分/ic:種別")
	private String eee6;


	/**
	 * 
	 */
	@JsonProperty("hj:区分/ic:表記")
	private String eee7;


	/**
	 * 
	 */
	@JsonProperty("hj:対象")
	private String eee8;

	/**
	 * 
	 */
	@JsonProperty("ic:金額/ic:数値")
	private String eee9;

	/**
	 * 
	 */
	@JsonProperty("hj:状況/ic:名称/ic:表記")
	private String eee10;

	/**
	 * 
	 * 
	 */
	@JsonProperty("ic:期間/ic:開始日時/ic:標準型日時")
	private String eee11;

	/**
	 * 
	 */
	@JsonProperty("ic:期間/ic:終了日時/ic:標準型日時")
	private String eeeea23;

	/**
	 * 
	 */
	@JsonProperty("hj:備考/ic:種別")
	private String eeee12;

	
	/**
	 * 
	 */
	@JsonProperty("hj:資格/ic:表記")
	private String eeee13;
	


	
	
	

}
