package kdt.fullstack.project.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

    @JsonProperty("DOCID")
    private String docId;

    @JsonProperty("movieId")
    private String movieId;

    @JsonProperty("movieSeq")
    private String movieSeq;

    @JsonProperty("title")
    private String title;

    @JsonProperty("titleEng")
    private String titleEng;

    @JsonProperty("prodYear")
    private String prodYear;

    @JsonProperty("directors")
    private DirectorListDTO directors;

    @JsonProperty("actors")
    private ActorListDTO actors;

    @JsonProperty("nation")
    private String nation;

    @JsonProperty("company")
    private String company;

    @JsonProperty("plots")
    private PlotListDTO plots;

    @JsonProperty("runtime")
    private String runtime;

    @JsonProperty("rating")
    private String rating;

    @JsonProperty("repRlsDate")
    private String repRlsDate;

    @JsonProperty("genre")
    private String genre;

    @JsonProperty("kmdbUrl")
    private String kmdbUrl;

    @JsonProperty("ratings")
    private RatingListDTO ratings;

    @JsonProperty("posters")
    private String posters;

    @JsonProperty("stlls")
    private String stlls;

    @JsonProperty("staffs")
    private StaffListDTO staffs;

    @JsonProperty("vods")
    private VodListDTO vods;

    @JsonProperty("Awards1")
    private String awards1;

    @JsonProperty("Awards2")
    private String awards2;

    @JsonProperty("regDate")
    private String regDate;

    @JsonProperty("modDate")
    private String modDate;

    @JsonProperty("Codes")
    private CodeListDTO codes;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class DirectorListDTO {
    @JsonProperty("director")
    private List<DirectorDTO> director;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class DirectorDTO {
    @JsonProperty("directorNm")
    private String directorNm;

    @JsonProperty("directorEnNm")
    private String directorEnNm;

    @JsonProperty("directorId")
    private String directorId;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ActorListDTO {
    @JsonProperty("actor")
    private List<ActorDTO> actor;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class ActorDTO {
    @JsonProperty("actorNm")
    private String actorNm;

    @JsonProperty("actorEnNm")
    private String actorEnNm;

    @JsonProperty("actorId")
    private String actorId;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PlotListDTO {
    @JsonProperty("plot")
    private List<PlotDTO> plot;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PlotDTO {
    @JsonProperty("plotLang")
    private String plotLang;

    @JsonProperty("plotText")
    private String plotText;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class RatingListDTO {
    @JsonProperty("rating")
    private List<RatingDTO> rating;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class RatingDTO {
    @JsonProperty("ratingMain")
    private String ratingMain;

    @JsonProperty("ratingDate")
    private String ratingDate;

    @JsonProperty("ratingNo")
    private String ratingNo;

    @JsonProperty("ratingGrade")
    private String ratingGrade;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("runtime")
    private String runtime;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StaffListDTO {
    @JsonProperty("staff")
    private List<StaffDTO> staff;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StaffDTO {
    @JsonProperty("staffNm")
    private String staffNm;

    @JsonProperty("staffEnNm")
    private String staffEnNm;

    @JsonProperty("staffRoleGroup")
    private String staffRoleGroup;

    @JsonProperty("staffRole")
    private String staffRole;

    @JsonProperty("staffId")
    private String staffId;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class VodListDTO {
    @JsonProperty("vod")
    private List<VodDTO> vod;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class VodDTO {
    @JsonProperty("vodClass")
    private String vodClass;

    @JsonProperty("vodUrl")
    private String vodUrl;

    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class CodeListDTO {
    @JsonProperty("Code")
    private List<CodeDTO> code;
    // getters and setters
}

@JsonIgnoreProperties(ignoreUnknown = true)
class CodeDTO {
    @JsonProperty("CodeNm")
    private String codeNm;
    
    @JsonProperty("CodeNo")
    private String codeNo;

    // getters and setters
}