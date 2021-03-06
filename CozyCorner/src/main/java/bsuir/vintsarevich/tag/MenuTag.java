package bsuir.vintsarevich.tag;

import bsuir.vintsarevich.entity.User;
import bsuir.vintsarevich.enumeration.AttributeParameterName;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * class ListTag is a Tag which can choose certain menu for including
 * */
public class MenuTag extends TagSupport {

    /**
     * @return int
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        User user = (User) pageContext.getSession().getAttribute(AttributeParameterName.USER.getValue());
        String menu = null;
        if (user != null) {
            switch (user.getRole()) {
                case "client":
                    menu = "/front/jsp/client/menu.jsp";
                    break;
                case "admin":
                    menu = "/front/jsp/admin/menu.jsp";
                    break;
                case "staff":
                    menu = "/front/jsp/staff/menu.jsp";
                    break;
            }
        } else {
            menu = "/front/jsp/common/menu.jsp";
        }
        try {
            pageContext.include(menu);
        } catch (IOException | ServletException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}