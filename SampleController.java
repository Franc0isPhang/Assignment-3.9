package sg.ntu.edu.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

//Separation of Controller file
@RestController
public class SampleController {

    //Dependency injection using the Autowired annotation
    //It allows Spring to resolve and inject collaborating beans into our bean.
    //The SampleItem class is treated by the SampleController as a Component bean.
    //This means that SampleController is dependent on a SampleItem for parts of its application that need its use.
    //with autowired, springboot would instantiate it for us everytime
    @Autowired
    private SampleItem sampleItem;

    //@Value is an annotation that can be used to get values from property / config files
    //In this example, @Value gets the information from application.properties in the resource folder
    //The application.properties is a file where system variables can be defined and used by the application
    //To use the value in the application.properties file, the name of the key must be called. It is then automatically assigned to the variable below.


    @GetMapping("/products/{id}")
public String getProductPage1(@PathVariable int id) {
    String productName;
    
    switch (id) {
        case 1:
            productName = "apple";
            break;
        case 2:
            productName = "banana";
            break;
        case 3:
            productName = "carrot";
            break;
        default:
            productName = "no product found";
            break;
    }

    return productName;
}


}
