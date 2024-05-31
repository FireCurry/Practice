const memberId = document.getElementById("member-id");
const memberPw = document.getElementById("member-pw");
const memberPwCheck = document.getElementById("member-pw-check");

// 유효성 검사용 객체
let checkObj = {
    "id" : false,
    "pw" : false,
    "check" : false
};

memberId.addEventListener("input", e=>{
    fetch(`/member/signup?memberId=${memberId.value}`)
        .then(resp=>resp.text())
        .then(result=>{
            if(result>0){
                e.target.nextElementSibling.innerText = "O";
                checkObj["id"] = true;
            } else {
                e.target.nextElementSibling.innerText = "X";
                checkObj["id"] = false;
            }
        })
        .catch(e=>console.log(e));
})

memberPw.addEventListener("input", e=>{

    if(memberPw.value === memberPwCheck.value){
        e.target.nextElementSibling.innerText = "O";
        checkObj["pw"] = true;
    } else {
        e.target.nextElementSibling.innerText = "X";
        checkObj["pw"] = false;
    }

});

memberPwCheck.addEventListener("input", e=>{

    if(memberPw.value === memberPwCheck.value){
        memberPw.nextElementSibling.innerText = "O";
        checkObj["check"] = true;
    } else {
        memberPw.nextElementSibling.innerText = "X";
        checkObj["check"] = false;
    }

});

const signupForm = document.getElementById("signup-form");

signupForm.addEventListener("submit", e=>{

    for(let key in checkObj){
        if(!checkObj[key]){
            switch(key){
                case "id" : alert("아이디가 유효하지않습니다."); break;
                default : alert("비밀번호가 일치하지 않습니다");
            }
            e.preventDefault();
            break;
        }
    }
});