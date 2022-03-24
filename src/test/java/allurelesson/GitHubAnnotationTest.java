package allurelesson;

import allurelesson.steps.WebSteps;
import org.junit.jupiter.api.Test;


public class GitHubAnnotationTest {
    private final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Can not generate Allure Reports on Jenkins";


    @Test
    public void searchForIssue(){
        final WebSteps steps = new WebSteps();

        steps.openMainPage(BASE_URL);
        steps.goToRepository(REPOSITORY);
        steps.goToIssue();
        steps.checkTitleIssue(ISSUE_NAME);
    }
}
