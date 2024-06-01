const memberId = document.getElementById("member-id");
const memberPw = document.getElementById("member-pw");
const memberPwCheck = document.getElementById("member-pw-check");
const memberIdCheck = document.getElementById("member-id-check")

// 유효성 검사용 객체
let checkObj = {
    "id" : false,
    "pw" : false,
};

memberIdCheck.addEventListener("click", e=>{

    fetch(`/member/idCheck?memberId=${memberId.value}`)
        .then(resp=>resp.text())
        .then(result=>{
            if(result>0){
                checkObj["id"] = false;
                alert("이미 존재하는 아이디입니다.");
            } else {
                checkObj["id"] = true;
                alert("사용할 수 있는 아이디입니다.");
            }
        })
        .catch(e=>console.log(e));
});

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
        checkObj["pw"] = true;
    } else {
        memberPw.nextElementSibling.innerText = "X";
        checkObj["pw"] = false;
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
