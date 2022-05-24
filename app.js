// clear Strorage
function clear() {
    localStorage.clear();
}

// create li with children 
let newLi = document.createElement("li"); 
let newImg1 = document.createElement("img");
newImg1.src = "Note/images/icon-check.svg";
newImg1.alt = "check.svg";
let newImg2 = document.createElement("img");
newImg2.src = "Note/images/icon-cross.svg";
newImg2.alt = "cross.svg";
newImg2.className = "cross";
let newP = document.createElement("p");

newLi.append(newImg1);
newLi.append(newP);
newLi.append(newImg2);

// add input
let form = document.forms[0];
let list = document.querySelector(".content ul");
let footer = document.querySelector("footer");
let [,b] = [...footer.children];
//let counter = 0;

b.onclick = function() {
    [...list.children].forEach(function(ele) {
        ele.remove();
    });
    counter = 0;
    a.textContent = `${counter} items left`;
    clear();
};

// Verif BOM has items
if(localStorage.length != 0) {
    counter = localStorage.length;
    let j = 1;
    for(let i=0; i<localStorage.length; i++) {
        let li = newLi.cloneNode(true);
        if(localStorage.getItem(`task${j}`).endsWith("T")) {
            li.children[1].textContent = localStorage.getItem(`task${j}`).slice(0,localStorage.getItem(`task${j}`).length - 1);
            li.className = "done";
            --counter;
        } else 
            li.children[1].textContent = localStorage.getItem(`task${j}`);
        list.append(li);
        a.textContent = `${counter} items left`;
        // li active
        li.addEventListener("click",function(e) {
            this.classList.toggle("done");
            
            if(e.target == li.lastChild) {
                if (this.className == "done") {
                    a.textContent = `${--counter} items left`;
                } else {
                    a.textContent = `${counter} items left`;
                }
                [...list.children].forEach(function(ele,i) {
                    if (ele.lastChild == e.target) {
                        localStorage.removeItem(`task${i+1}`);
                    }
                });
                this.remove();
            } else {
                if (this.className == "done") {
                    a.textContent = `${--counter} items left`;
                    window.localStorage.setItem(`task${i+1}`,`${this.textContent}T`);
                } else {
                    a.textContent = `${++counter} items left`;
                    window.localStorage.setItem(`task${i+1}`,`${this.textContent}`);
                }
            }
        });
        j++;
    }

}

form[1].addEventListener("click",function(e) {
    e.preventDefault();
    if(! form[0].value == "") {
        let li = newLi.cloneNode(true);
        li.children[1].textContent = form[0].value;
        list.append(li);

        a.textContent = `${++counter} items left`;

        //start BOM
        window.localStorage.setItem(`task${counter}`,`${form[0].value}`);

        // li active
        li.addEventListener("click",function(e) {
            this.classList.toggle("done");
            
            if(e.target == li.lastChild) {
                if (this.className == "done") {
                    a.textContent = `${--counter} items left`;
                } else {
                    a.textContent = `${counter} items left`;
                }
                [...list.children].forEach(function(ele,i) {
                    if (ele.lastChild == e.target) {
                        localStorage.removeItem(`task${i+1}`);
                    }
                });
                this.remove();
            } else {
                if (this.className == "done") {
                    a.textContent = `${--counter} items left`;
                    window.localStorage.setItem(`task${i+1}`,`${this.textContent}T`);
                } else {
                    a.textContent = `${++counter} items left`;
                }
            }
        });
        // set BOM
        [...list.children].forEach(function(ele,i) {
            ele.addEventListener("click",function() {
                if(this.className == "done") {
                    window.localStorage.setItem(`task${i+1}`,`${this.textContent}T`);
                } else 
                    window.localStorage.setItem(`task${i+1}`,`${this.textContent}`);
            });
        });
    }
    form[0].value = "";
});
