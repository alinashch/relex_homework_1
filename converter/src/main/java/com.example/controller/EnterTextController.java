package com.example.controller;

import com.example.model.UsersMessage;
import com.example.model.UsersMessageEvent;
import com.example.scripts.CSVwriter;
import com.example.scripts.Caesar;
import com.example.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EnterTextController {

    private final UserService userAndMessagesService;



    public EnterTextController(UserService userAndMessagesService) {
        this.userAndMessagesService = userAndMessagesService;

    }


    @RequestMapping(value="/enterPage", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("enter", new UsersMessage());
        return "enter";
    }

    @RequestMapping(value="/enterPage", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UsersMessage greeting, Model model) {
        Caesar caesar =new Caesar();
        greeting.setConvertMessage(caesar.cipher(greeting.getMessage(), 3));

        CSVwriter csVwriter=new CSVwriter();
        csVwriter.writeStringsOnCSV(greeting.toString());


        userAndMessagesService.insert(greeting);

        model.addAttribute("enter", greeting);
        return "result";
    }


    @GetMapping("/download")
    public void download ( HttpServletResponse response) throws IOException {

        Path file = Paths.get("D://file.csv");

        String contentType = Files.probeContentType(file);
        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        response.setContentType(contentType);
        response.setContentLengthLong(Files.size(file));

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                .filename(file.getFileName().toString(), StandardCharsets.UTF_8)
                .build()
                .toString());
        Files.copy(file, response.getOutputStream());
    }



    @RequestMapping(value = "/showAll")
    public String addIngredientsToModel(Model model) {
        Iterable<UsersMessage> usersAndMessages = userAndMessagesService.findAll();
        List<UsersMessage> list=new ArrayList<>();
        for (UsersMessage user : usersAndMessages) {
            list.add(user);
        }
        model.addAttribute("user",list);

        return "showAll";
    }
}
