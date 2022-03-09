//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ThymeleafBeans {

    // Return the URL with lang request parameter removed.
    // This can then be replaced (using Thymeleaf) by a different lang=iso_code
    public String removeLangFromUrl()
    {
        return ServletUriComponentsBuilder.fromCurrentRequest().replaceQueryParam("lang").toUriString();
    }

}