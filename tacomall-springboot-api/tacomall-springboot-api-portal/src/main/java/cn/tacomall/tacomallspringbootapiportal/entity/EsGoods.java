package cn.tacomall.tacomallspringbootapiportal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "goods")
public class EsGoods implements Serializable {

    @Id
    private String id;

    private String name;

    private int price;

    private String brand;

}

