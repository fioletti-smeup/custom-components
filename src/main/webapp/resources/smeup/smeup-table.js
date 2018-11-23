class SmeupTable extends HTMLElement {
  constructor() {
    super();

  }
  connectedCallback(){
	  
	    const shadow = this.attachShadow({mode: 'open'});

	    const style = document.createElement('style');
	    style.textContent = "td {border: 1px solid black}";
	    
	    shadow.appendChild(style);

	    
	    const letValueName = this.getAttribute('value');
	    console.log(letValueName);
	    const v = window[letValueName];
	    console.log(JSON.stringify(v));
	    
	    const table = document.createElement('table');
	    shadow.appendChild(table);
	    const onCellClicked = this.getAttribute('oncellclicked');
	    
	    v.table.rows.forEach((r) => {
	    	let tr = document.createElement('tr');
	    	
	    	r.cells.forEach((d) => {
	    		let td =document.createElement('td');
	    		td.textContent = d;
	    		if(onCellClicked){
	    		td.addEventListener("click", (e) => {
	    			let event=new Event("{\"cell\":\""+td.textContent+"\"}");
	    			eval(onCellClicked);
	    			});
	    		
	    	}
	    		tr.appendChild(td);
	    		}
	    		);
	    	
	    	shadow.appendChild(tr);
		    
	    	});
  }
}

customElements.define('smeup-table', SmeupTable);
