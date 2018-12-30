	//для ползуноков
		var arrayDrinks = [
			{
				key:document.getElementById('cola'), 
				percent : 0  
			},
			{
				key:document.getElementById('vodka'), 
				percent : 40
			},
			{
				key:document.getElementById('whisky'), 
				percent : 43
			},
			{
				key:document.getElementById('beer'), 
				percent : 5
			},
			{
				key:document.getElementById('gin'), 
				percent : 37.5
			},
			{
				key:document.getElementById('tonic'), 
				percent : 0
			}
		];
  
	// для percent
	var percent = document.getElementById('percent');
	var status = document.getElementById('status');

	arrayDrinks.forEach((e)=>{
		e.key.addEventListener("change",(event) => {changePercent(event)});
	});	
	
	
	
	function changePercent(eventObj){
		
				
		var cocktailVolume = 0;
		var alcoholVolume = 0;
		var alcoholPercent;
		
		arrayDrinks.forEach((e)=>{
			cocktailVolume += parseInt(e.key.value);
		});	

		/*parseInt(cola.value) + parseInt(vodka.value) + parseInt(whisky.value)
			+ parseInt(beer.value) + parseInt(gin.value) + parseInt(tonic.value);*/

			
		if(cocktailVolume!=0){
		
			arrayDrinks.forEach((e)=>{
				//alcoholVolume += parseInt(e.key.value)*e.percent/cocktailVolume;
				alcoholVolume += parseInt(e.key.value)*e.percent;
			});	
			
			alcoholPercent = alcoholVolume/cocktailVolume;

			status.innerHTML = "";
			percent.innerHTML = "Процент алкоголя: " + parseInt(alcoholPercent) + "%. " + "Текущий объём коктейля: " + cocktailVolume + " мл.";
		}else{
			percent.innerHTML = "Процент алкоголя: 0%. Текущий объём коктейля: 0 мл.";
		}
		changeCircleColor(eventObj);
				
		
	}
	function changeCircleColor(eventObj){

		//let color = eventObj.target.nextSibling.nextSibling.style;
		//let color = getComputedStyle(eventObj.target.nextSibling.nextSibling).backgroundColor;
		
		//console.log(color);
				
		//if(parseInt(eventObj.target.value)!=0){ color="rgb(0,255,0)"; }
		//else{ color = "rgb(255,0,0)";}
		
				
		if(parseInt(eventObj.target.value)!=0){ eventObj.target.nextSibling.nextSibling.style.backgroundColor="green"; }
		else{ eventObj.target.nextSibling.nextSibling.style.backgroundColor = "red";}
		
	}