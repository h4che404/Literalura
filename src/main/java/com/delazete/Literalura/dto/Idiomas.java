package com.delazete.Literalura.dto;

public enum Idiomas {
    AF("[af]", "Afrikáans"),
    SQ("[sq]", "Albanés"),
    AM("[am]", "Amárico"),
    AR("[ar]", "Árabe"),
    HY("[hy]", "Armenio"),
    AZ("[az]", "Azerbaiyano"),
    EU("[eu]", "Euskera"),
    BE("[be]", "Bielorruso"),
    BN("[bn]", "Bengalí"),
    BS("[bs]", "Bosnio"),
    BG("[bg]", "Búlgaro"),
    CA("[ca]", "Catalán"),
    CEB("[ceb]", "Cebuano"),
    NY("[ny]", "Chichewa"),
    ZH("[zh]", "Chino (simplificado)"),
    ZH_TW("[zh-TW]", "Chino (tradicional)"),
    CO("[co]", "Corso"),
    HR("[hr]", "Croata"),
    CS("[cs]", "Checo"),
    DA("[da]", "Danés"),
    NL("[nl]", "Neerlandés"),
    EN("[en]", "Inglés"),
    EO("[eo]", "Esperanto"),
    ET("[et]", "Estonio"),
    TL("[tl]", "Filipino"),
    FI("[fi]", "Finlandés"),
    FR("[fr]", "Francés"),
    FY("[fy]", "Frisón"),
    GL("[gl]", "Gallego"),
    KA("[ka]", "Georgiano"),
    DE("[de]", "Alemán"),
    EL("[el]", "Griego"),
    GU("[gu]", "Gujarati"),
    HT("[ht]", "Criollo haitiano"),
    HA("[ha]", "Hausa"),
    HAW("[haw]", "Hawaiano"),
    HE("[he]", "Hebreo"),
    IW("[iw]", "Hebreo"),
    HI("[hi]", "Hindi"),
    HMN("[hmn]", "Hmong"),
    HU("[hu]", "Húngaro"),
    IS("[is]", "Islandés"),
    IG("[ig]", "Igbo"),
    ID("[id]", "Indonesio"),
    GA("[ga]", "Irlandés"),
    IT("[it]", "Italiano"),
    JA("[ja]", "Japonés"),
    JW("[jw]", "Javanés"),
    KN("[kn]", "Canarés"),
    KK("[kk]", "Kazajo"),
    KM("[km]", "Jemer"),
    RW("[rw]", "Kinyarwanda"),
    KY("[ky]", "Kirguís"),
    KO("[ko]", "Coreano"),
    KU("[ku]", "Kurdo (Kurmanji)"),
    LO("[lo]", "Lao"),
    LA("[la]", "Latín"),
    LV("[lv]", "Letón"),
    LT("[lt]", "Lituano"),
    LB("[lb]", "Luxemburgués"),
    MK("[mk]", "Macedonio"),
    MG("[mg]", "Malgache"),
    MS("[ms]", "Malayo"),
    ML("[ml]", "Malayalam"),
    MT("[mt]", "Maltés"),
    MI("[mi]", "Maorí"),
    MR("[mr]", "Marathi"),
    MN("[mn]", "Mongol"),
    MY("[my]", "Birmano"),
    NE("[ne]", "Nepalí"),
    NO("[no]", "Noruego"),
    NYN("[ny]", "Chichewa"),
    PS("[ps]", "Pastún"),
    FA("[fa]", "Persa"),
    PL("[pl]", "Polaco"),
    PT("[pt]", "Portugués"),
    PA("[pa]", "Punyabí"),
    RO("[ro]", "Rumano"),
    RU("[ru]", "Ruso"),
    SM("[sm]", "Samoano"),
    GD("[gd]", "Gaélico escocés"),
    SR("[sr]", "Serbio"),
    ST("[st]", "Sesotho"),
    SN("[sn]", "Shona"),
    SD("[sd]", "Sindhi"),
    SI("[si]", "Cingalés"),
    SK("[sk]", "Eslovaco"),
    SL("[sl]", "Esloveno"),
    SO("[so]", "Somalí"),
    ES("[es]", "Espanol"),
    SU("[su]", "Sundanés"),
    SW("[sw]", "Suajili"),
    SV("[sv]", "Sueco"),
    TG("[tg]", "Tayiko"),
    TA("[ta]", "Tamil"),
    TE("[te]", "Telugu"),
    TH("[th]", "Tailandés"),
    TR("[tr]", "Turco"),
    UK("[uk]", "Ucraniano"),
    UR("[ur]", "Urdu"),
    UZ("[uz]", "Uzbeko"),
    VI("[vi]", "Vietnamita"),
    CY("[cy]", "Galés"),
    XH("[xh]", "Xhosa"),
    YI("[yi]", "Yidis"),
    YO("[yo]", "Yoruba"),
    ZU("[zu]", "Zulú");

    private final String iniciales;
    private final String nombreCompleto;

    Idiomas(String iniciales, String nombreCompleto) {
        this.iniciales = iniciales;
        this.nombreCompleto = nombreCompleto;
    }

    public static Idiomas fromString(String iniciales) {
        for (Idiomas idioma : Idiomas.values()) {
            if (idioma.iniciales.equalsIgnoreCase(iniciales)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + iniciales);
    }
    public String toString(){
        String idioma = "Idioma:" + nombreCompleto;
        return idioma;
    }
}
