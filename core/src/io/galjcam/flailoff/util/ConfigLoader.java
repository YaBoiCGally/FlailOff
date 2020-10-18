/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

/**
 *
 * @author Cam
 */
public class ConfigLoader {
    
    class Config {
        public Map<String, Double> physics;
        public Map<String, Character> controls;
        public Map<String, Boolean> powerUps;
    }
    
    private Yaml yaml;
    private Config config;
    
    public ConfigLoader() {
        this("config.json");
    }
    
    public ConfigLoader(String configName) {
        this.yaml = new Yaml();  
        try(InputStream in = Files.newInputStream(Paths.get(configName))) {
            this.config = yaml.loadAs(in, Config.class);
        } catch (IOException ex) {
            System.out.println("Invalid config file: " + configName);
        }
    }
    
    public Double getPhysic(String key) {
        return config.physics.get(key);
    }

    public Character getControl(String key) {
        return config.controls.get(key);
    }
    
    public Boolean getPowerUp(String key) {
        return config.powerUps.get(key);
    }
}

