package kdt.fullstack.project.domain;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxItems {
    
    @JsonProperty("weeklyBoxOfficeList")
    private List<BoxOfficeDTO> boxItems;

    @JsonCreator
    public BoxItems(@JsonProperty("boxOfficeResult") JsonNode node) {
        try {
            if (node != null) {
                JsonNode itemNode = node.findValue("weeklyBoxOfficeList");
                if (itemNode != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    this.boxItems = Arrays.asList(mapper.treeToValue(itemNode, BoxOfficeDTO[].class));
                } else {
                    System.err.println("Result node not found in the response");
                }
            } else {
                System.err.println("Response node is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
