
var form = document.getElementById("form-section");
 var  isActive = true;


   function display (){
       form.style.display = "block";
}
function Nodisplay(){

       form.style.display="none";
}
//------------------------------------------------

function switchValue(value){
    let defaultRangeInpute = document.getElementById("default-range").value;
    let defaultRangeMounth = document.getElementById("defaultMounth").value;
    let displayValueMounth = document.getElementById("displayMounth");
   let displayValue = document.getElementById("display-value");
   let TotalInput = document.getElementById("totalInput");

    displayValue.setAttribute("value",defaultRangeInpute+" DH")
    displayValueMounth.setAttribute("value",defaultRangeMounth)

    TotalInput.value = +defaultRangeInpute + +defaultRangeMounth;
}




   function displaySlide(){
       let slide = document.getElementById("slideInfo");
       let buttonClick = document.getElementById("buttonSlide");
        if(isActive){
            slide.style.left= "78%";
            slide.style.transition = "left 3s ease-out";
            slide.style.boxShadow = "10px 19px 10px 10px black"
            buttonClick.style.transform = "rotate(0deg)"
            buttonClick.style.transition = "transform 3s ease-out"
            isActive = false;
        }else{
            slide.style.left= "98%";
            slide.style.transition = "left 3s ease-out";
            slide.style.boxShadow = "none"
            buttonClick.style.transform = "rotate(181deg)"
            buttonClick.style.transition = "transform 3s ease-out"
            isActive= true
        }

   }

   function  addInfo(){

   }