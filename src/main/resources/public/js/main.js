var app = app || {};

app.init = function() {
    app.roomReservation.datePickersWorking();
    app.roomReservation.carouselWorking();
    app.roomReservation.listenRoomSelection();
};

$(document).ready(app.init());