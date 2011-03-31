var SEATS_COLUMNS = 16;
var SEATS_ROWS = 10;
var MAX_SEATS = 10;

window["SEAT_DATA"] = [];
window["SEATS_COLUMNS"] = 1;
window["SEATS_ROWS"] = 1;
window["SEATS_ROWS_PREMIUM"] = 0;
window["MAX_SEATS"] = 1;

window["Seats"] = {
	arrSeatMappings:[],
	arrChosenSeats:[],
	intChosenTime:-1,

	initialize:function() {
		for (var intRow=1; intRow<=SEATS_ROWS; intRow++) {
			this.arrSeatMappings[intRow] = [];
			for (var intColumn=1; intColumn<=SEATS_COLUMNS; intColumn++) {
				var objCell = this.getSeatCell(intRow,intColumn);
				this.arrSeatMappings[intRow][intColumn] = {premium:((SEATS_ROWS-intRow)<SEATS_ROWS_PREMIUM), used:false, selected:false, cell:objCell, row:intRow, column:intColumn};
				Event.observe(objCell,'click',this.seatClicked.bind(this,objCell,intRow,intColumn));
			}
		}

		if (SEAT_DATA.length < 1) {
			alert("Sorry, but the film is not showing on the selected date");
			return false;
		}
		else {
			return this.loadData(0);
		}
	},

	loadData:function(intTime) {
		if (intTime >= SEAT_DATA.length) {
			alert("Sorry, but there is no seat data for that time slot");
			return false;
		}
		else if (this.intChosenTime == intTime) {
			return true;
		}

		if (this.arrChosenSeats.length > 0) {
			if (!confirm("Changing times will clear your current seat choices.\n\nContinue?")) {
				$("time").selectedIndex = this.intChosenTime;
				return false;
			}
		}

		$("time").selectedIndex = intTime;
		$("screen").innerHTML = SEAT_DATA[intTime].screen;
		this.intChosenTime = intTime;

		this.reset();

		for (var intRow=1; intRow<=SEATS_ROWS; intRow++) {
			for (var intColumn=1; intColumn<=SEATS_COLUMNS; intColumn++) {
				var objSeat = this.getSeat(intRow,intColumn);
				objSeat.used = SEAT_DATA[intTime].seats[intRow-1][intColumn-1];
				objSeat.cell.removeClassName("seat-unused").removeClassName("seat-used").removeClassName("seat-premium").removeClassName("seat-normal").addClassName("seat-"+(objSeat.used?"":"un")+"used").addClassName("seat-"+(objSeat.premium?"premium":"normal"));
			}
		}

		return true;
	},

	reloadData:function() {
		setTimeout(this.loadData.bind(this,$("time").selectedIndex),50);
	},

	getSeat:function(intRow,intColumn) {
		return this.arrSeatMappings[intRow][intColumn];
	},

	getSeatName:function(intRow,intColumn) {
		return ("seat-" + String.fromCharCode(intRow+64) + (intColumn<10?"0":"") + intColumn);
	},

	getSeatCell:function(intRow,intColumn) {
		return $(this.getSeatName(intRow,intColumn));
	},

	seatClicked:function(objCell,intRow,intColumn) {
		var objSeat = this.getSeat(intRow,intColumn);
		if (!objSeat.used) {
			if (!objSeat.selected && (this.arrChosenSeats.length >= MAX_SEATS || MAX_SEATS < 0)) {
				alert("You have reached the maximum amount of seats that can be booked in one booking");
			}
			else {
				objSeat.selected = !objSeat.selected;
				objCell.toggleClassName("seat-unused").toggleClassName("seat-"+(objSeat.premium?"premium":"normal")).toggleClassName("seat-selected-"+(objSeat.premium?"premium":"normal"));
				if (objSeat.selected) {
					this.arrChosenSeats[this.arrChosenSeats.length] = objSeat;
				}
				else {
					var intFoundIndex = -1;
					for (var intIndex=0; intIndex<this.arrChosenSeats.length; intIndex++) {
						if (this.arrChosenSeats[intIndex] == objSeat) {
							intFoundIndex = intIndex;
							break;
						}
					}
					if (intFoundIndex == -1) {
						alert("Unexpected Error: Could not remove seat booking. Please reload the page");
					}
					else {
						this.arrChosenSeats.splice(intFoundIndex,1);
					}
				}
				this.updateData();
			}
		}
	},

	updateData:function() {
		var strData = "";
		var objPriceData = SEAT_DATA[this.intChosenTime].price;
		var dblTotalPrice = 0;
		for (var intIndex=0; intIndex<this.arrChosenSeats.length; intIndex++) {
			var objSeat = this.arrChosenSeats[intIndex];
			strData += "|" + objSeat.row + "," + objSeat.column;
			dblTotalPrice += (objSeat.premium?objPriceData.premium:objPriceData.normal);
		}
		var strTotalPrice = ""+Math.round(dblTotalPrice*100);
		while (strTotalPrice.length < 3) {
			strTotalPrice = "0" + strTotalPrice;
		}
		strTotalPrice = strTotalPrice.substr(0,strTotalPrice.length-2) + "." + strTotalPrice.substr(strTotalPrice.length-2,2);

		$("seats").value = strData.substr();
		$("price_display").innerHTML = strTotalPrice;
		$("price").value = strTotalPrice;

		if (this.arrChosenSeats.length >= 1) {
			$("action_next").disabled = "";
		}
		else {
			$("action_next").disabled = "disabled";
		}
	},

	reset:function() {
		for (var intIndex=this.arrChosenSeats.length-1; intIndex>=0; intIndex--) {
			var objSeat = this.arrChosenSeats[intIndex];
			this.seatClicked(objSeat.cell,objSeat.row,objSeat.column);
		}
	}
};

Event.observe(window,'load',function() {
	Seats.initialize();
});
