package life.majiang.community.service;

import com.github.pagehelper.Page;
import life.majiang.community.dto.PageDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public Page<QuestionDTO> list() {
        Page<Question> questions = questionMapper.list();
        Page<QuestionDTO> questionDTOList = new Page<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }

    public PageDTO pages(Integer pageNum, Integer pageSize) {
        Integer totalNum = (int) (Math.ceil(questionMapper.getTotalNum() / pageSize));
        List<Integer> Pages = new ArrayList<>();

        Boolean showFirstPage = true;
        Boolean showLastPage = true;
        Boolean showPreviousPage = pageNum > 1;
        Boolean showLatterPage = pageNum < totalNum;


        for (int pageIndex = pageNum - 2; pageIndex < pageNum + 3; pageIndex++) {
            if (pageIndex < 1) {
                showFirstPage = false;
                continue;
            }
            if (pageIndex > totalNum) {
                showLastPage = false;
                continue;
            }
            Pages.add(pageIndex);
        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPages(Pages.toArray());
        pageDTO.setShowFirstPage(showFirstPage);
        pageDTO.setShowLastPage(showLastPage);
        pageDTO.setShowLatterPage(showLatterPage);
        pageDTO.setShowPreviousPage(showPreviousPage);
        pageDTO.setTotalPage(totalNum);
        pageDTO.setPageNum(pageNum);
        return pageDTO;
    }
}
