package com.second.talentstock.interestTag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InterestTagController {
}
