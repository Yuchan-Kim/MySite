<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="http://localhost:8888/mysite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="http://localhost:8888/mysite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div id="wrap">

        <!-- Include header -->
        <c:import url="/WEB-INF/views/include/header.jsp"></c:import>

        <div id="container" class="clearfix">
            <div id="aside">
                <h2>회원</h2>
                <ul>
                    <li>회원정보</li>
                    <li>로그인</li>
                    <li>회원가입</li>
                </ul>
            </div>
            <!-- //aside -->

            <div id="content">

                <div id="content-head">
                    <h3>회원가입</h3>
                    <div id="location">
                        <ul>
                            <li>홈</li>
                            <li>회원</li>
                            <li class="last">회원가입</li>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
                <!-- //content-head -->

                <c:if test="${sessionScope.authUser != null}">
                <div id="user">
                    <div id="modifyForm"> <!-- Changed from editForm to match the CSS selector -->

                        <form action="/mysite/user/update" method="post">
    
                            <!-- 아이디 -->
                            <div class="form-group">
                                <label class="form-text" for="input-uid">아이디</label> 
                                <input type="text" id="input-uid" name="id" value="${authUser.userId}">
                                <button type="button" id="duplicateCheck" class="btn">중복체크</button>
                            </div>
    
                            <!-- 비밀번호 -->
                            <div class="form-group">
                                <label class="form-text" for="input-pass">패스워드</label> 
                                <input type="password" id="input-pass" name="pw" value="${authUser.userPw}">
                            </div>
    
                            <!-- 이름 -->
                            <div class="form-group">
                                <label class="form-text" for="input-name">이름</label> 
                                <input type="text" id="input-name" name="name" value="${authUser.userName}">
                            </div>
    
                            <!-- 성별 -->
                            <div class="form-group">
                                <span class="form-text">성별</span>
                                
                                <label for="rdo-male">남</label> 
                                <input type="radio" id="rdo-male" name="gender" value="male" ${authUser.userGender == 'male' ? 'checked' : ''}>
                                
                                <label for="rdo-female">여</label> 
                                <input type="radio" id="rdo-female" name="gender" value="female" ${authUser.userGender == 'female' ? 'checked' : ''}>
    
                            </div>
    
                            <!-- 약관동의 -->
                            <div class="form-group">
                                <span class="form-text">약관동의</span>
                                
                                <input type="checkbox" id="chk-agree" name="" value="">
                                <label for="chk-agree">서비스 약관에 동의합니다.</label>
                            </div>
    
                            <!-- 버튼영역 -->
                            <div class="button-area">
                             
                                <button type="submit" id="btn-submit" class="btn">수정</button>
                            </div>
    
                        </form>
                    </div>
                    <!-- //joinForm -->
                </div>
                <!-- //user -->
                </c:if>
            </div>
            <!-- //content  -->
        </div>
        <!-- //container  -->

        <!-- Include footer -->
        <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
        <!-- //footer -->

    </div>
    <!-- //wrap -->

</body>
</html>
