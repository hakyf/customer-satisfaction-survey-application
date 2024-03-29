package id.co.mii.clientapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import id.co.mii.clientapp.model.Survey;
import id.co.mii.clientapp.model.dto.request.QuestionAnswerRequest;

@Service
public class SurveyService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.baseUrl}/survey")
    private String url;

    public List<Survey> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Survey>>() {
                }).getBody();
    }

    public Survey getById(Long id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey create(Survey survey) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(survey),
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey send(Survey survey) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(survey),
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey update(Long id, Survey survey) {
        return restTemplate.exchange(
                url.concat("/" + id),
                HttpMethod.PUT,
                new HttpEntity(survey),
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey delete(Long id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey formByCode(String code) {
        return restTemplate.exchange(
                url + "/c/" + code,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey sendSurveyAnswer(String code, List<QuestionAnswerRequest> qar) {
        return restTemplate.exchange(
                url + "/answer/" + code,
                HttpMethod.POST,
                new HttpEntity(qar),
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

    public Survey reviewSurvey(String code) {
        return restTemplate.exchange(
                url + "/c/" + code + "/review",
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<Survey>() {
                }).getBody();
    }

}
