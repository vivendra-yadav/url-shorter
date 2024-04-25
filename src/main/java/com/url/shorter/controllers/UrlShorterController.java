package com.url.shorter.controllers;
import com.url.shorter.UrlPayload;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController("api")
public class UrlShorterController {
    HashMap<String, String> url_data = new HashMap<>();
    @PostMapping ("/url_shorter")
    public String url_shorter (@RequestBody UrlPayload url) {
        String sb = "";
        String BASE62_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&";

        while (true) {
            for (int i = 0; i < 11; i++) {
                int index = (int) (Math.random() * BASE62_CHARACTERS.length());
                sb = sb + BASE62_CHARACTERS.charAt(index);
            }
            if (!url_data.containsKey(sb)) {
                url_data.put(sb, url.getUrl());
                return sb;

            }

        }
    }

    @GetMapping("/original_url/{shorter_url}")
    public String original_url(@PathVariable String shorter_url){
        return url_data.get(shorter_url);
    }

}