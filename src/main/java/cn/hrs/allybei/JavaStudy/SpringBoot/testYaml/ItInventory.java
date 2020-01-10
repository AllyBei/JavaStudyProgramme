package cn.hrs.allybei.JavaStudy.SpringBoot.testYaml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * IT Inventory info
 * includes:
 * hostname,username
 * if over warrenty?
 * purchase date
 */
@Data
@Component
@EnableAutoConfiguration
//@ConfigurationProperties(prefix = "ItInventory")

//TODO
//Test prefix auto configuration settings

public class ItInventory {
    @Value("${ItInventory.hostName}")
    private String hostName;
    @Value("${ItInventory.userName}")
    private String userName;
    @Value("${ItInventory.isOverWarrenty}")
    private Boolean isOverWarrenty;
    @Value("${ItInventory.purchaseDate}")
    private Date purchaseDate;
}
