package by.it.project.java.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})

public class FilterUTF8 implements Filter {
    private String coding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        coding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String codingRequest = request.getCharacterEncoding();

        // установка кодировки из параметров фильтра, если не установлена
        if (coding != null && !coding.equalsIgnoreCase(codingRequest)) {
            request.setCharacterEncoding(coding);
        }

        String codingResponse = response.getCharacterEncoding();
        if (coding != null && !coding.equalsIgnoreCase(codingResponse)) {
            response.setCharacterEncoding(coding);
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        coding = null;
    }
}