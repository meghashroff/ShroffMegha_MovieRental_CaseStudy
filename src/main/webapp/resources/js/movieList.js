function selectedGenre(value){
	var genre = document.getElementById("genre");
	alert(value);
}


function toggle(source) {
  allCheckboxes = document.getElementsByName('selectedMovies');
  for(var i=0, n=allCheckboxes.length;i<n;i++) {
    allCheckboxes[i].checked = source.checked;
  }
}

function movieSel(){

	var mes = document.querySelector("h4");
	var checkboxes = document.querySelectorAll("#checkedMovies");
	for(var i=0;i<checkboxes.length; i++)
	{
		if(checkboxes[i].checked==true){
			return true;
		}
	}
	mes.innerHTML="Please select atleast one";
	return false;
}


function filterByGenre(value){
    // console.log(value);
    // var genreList = document.getElementsByClassName(value);
    // console.log("genre: "+genreList);
    // let tbody = document.getElementById('tbody');
    // // var originalList = tbody;
    // // function setOriginalList(originalList);
    // console.log(tbody.children);
    // for(c=0; c<tbody.children.length; c++){
    //     if(tbody.children[c].className != value){
    //     tbody.children[c].style.display="none";
    //     // console.log(c);
    //     } 
    // }

	alert(value);
    let list = document.getElementsByTagName('tr');
    let originalList = list;
    let trList = setOriginalList(originalList);
    for(cs=0; cs<trList.length; cs++){
        if(value!== "all"){
            trList[0].style.display="revert";
            

            if(trList[cs].className !== value){
                trList[cs].style.display="none";
            } 
            else {
                trList[cs].style.display="revert";
            }
        }
        else {
            trList[cs].style.display="revert";
        }
    }
}

function setOriginalList(allList){
    var fullList = allList;
    console.log("Full List: "+fullList);
    return fullList;

}

