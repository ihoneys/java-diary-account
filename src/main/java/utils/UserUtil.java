/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/22
 */
package utils;

import com.ledgerserver.common.Constants;
import com.ledgerserver.entity.User;
import com.ledgerserver.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {
    public static Integer getUserIdFormToken(HttpServletRequest request, UserRepository userRepository) {
        String token = request.getHeader(Constants.AUTHORIZATION);
        String username = TokenUtil.getUsernameFormToken(token);
        User userinfo = userRepository.findByUsername(username);
        int userId = userinfo.getId();
        return userId;
    }
}
