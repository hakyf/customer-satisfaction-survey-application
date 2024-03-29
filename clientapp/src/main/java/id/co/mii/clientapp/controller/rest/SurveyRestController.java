package id.co.mii.clientapp.controller.rest;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.clientapp.model.Survey;
import id.co.mii.clientapp.model.dto.request.QuestionAnswerRequest;
import id.co.mii.clientapp.service.SurveyService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/survey")
@AllArgsConstructor
public class SurveyRestController {

    private SurveyService surveyService;

    @GetMapping
    public List<Survey> getAll() {
        return surveyService.getAll();
    }

    @GetMapping("/{id}")
    public Survey getById(@PathVariable Long id) {
        return surveyService.getById(id);
    }

    @PostMapping
    public Survey create(@RequestBody Survey survey) {
        return surveyService.create(survey);
    }

    @PutMapping("/{id}")
    public Survey update(@PathVariable Long id, @RequestBody Survey survey) {
        return surveyService.update(id, survey);
    }

    @DeleteMapping("/{id}")
    public Survey delete(@PathVariable Long id) {
        return surveyService.delete(id);
    }

    @GetMapping("/c/{code}")
    public Survey formByCode(@PathVariable String code) {
        return surveyService.formByCode(code);
    }

    @PostMapping("/answer/{code}")
    public Survey sendAnswerSurvey(@PathVariable String code, @RequestBody List<QuestionAnswerRequest> qar) {
        return surveyService.sendSurveyAnswer(code, qar);
    }

}
