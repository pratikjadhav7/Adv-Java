function addStudent(){

    const student={

        rollno:document.getElementById("rollno").value,
        name:document.getElementById("name").value,
        marks:document.getElementById("marks").value
    }

    fetch("http://localhost:8080/studentmanagement/studentapi/addstudent",
        {
            method:"POST",
            body:JSON.stringify(student)
        }
    ).then(response=>response.json())
    .then(data=>display(data))
}

function display(data){
         document.getElementById("outputspan").innerHTML=data.msg;
}

function searchStudent(){
     rollno=document.getElementById("searchbox").value;
     fetch("http://localhost:8080/studentmanagement/studentapi/searchstudentbyroll?rollno="+rollno)
         .then(response => response.json())
         .then(datajson =>displayonpage(datajson))
}

function displayonpage(datajson){

    if(datajson.status==404){
        document.getElementById("displaypage").innerHTML="Student not found";
    }
   else if(datajson.status==200){

        student=datajson.data[0];
        
        html=`rollno=${student.rollno}
        name=${student.name}
        marks=${student.marks}
        `

        document.getElementById("displaypage").innerHTML=html
    }else{
        document.getElementById("displaypage").innerHTML="Internal server error";
    }
}

function displayAll(){
    fetch("http://localhost:8080/studentmanagement/studentapi/displayallstudents")
        .then(response => response.json())
        .then(datajson =>displayallonpage(datajson))
}

function displayallonpage(datajson){
    if(datajson.status==200){
        students=datajson.data

        html=``;

        for(i=0;i<students.length;i++){
            student=students[i]
        html=html+`rollno=${student.rollno}
        name=${student.name}
        marks=${student.marks} <br>
        `
        }
        document.getElementById("displayallonpage").innerHTML=html
        
    }else{
         document.getElementById("dipsplayallonpage").innerHTML="Students Not found";
    }
}        