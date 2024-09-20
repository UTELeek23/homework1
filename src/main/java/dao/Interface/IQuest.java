package dao.Interface;

import Models.Questions;

import java.util.List;
import java.util.Queue;

public interface IQuest {
    List<Questions> getQuestions();
    int findID(String question);
}
