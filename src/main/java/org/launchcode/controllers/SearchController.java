package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String results(Model model, String searchType, String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);
        if (searchType.equals("all")) {
            model.addAttribute("jobs", JobData.findAll());
        }
        else {
            model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        }

        return "search";
    }
}
