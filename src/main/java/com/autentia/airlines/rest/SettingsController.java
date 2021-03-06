package com.autentia.airlines.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.airlines.config.SettingsConfig;


@RestController
public class SettingsController {
	
	@Autowired
    private SettingsConfig settingsConfig;

    @GetMapping("/version")
    public String getVersion() {
        return "VERSIÓN MOD: " + this.settingsConfig.getVersion();
    }

}
