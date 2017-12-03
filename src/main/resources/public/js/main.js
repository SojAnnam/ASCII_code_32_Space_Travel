var app = app || {};

app.init = function() {
    app.datePicker.datePickersWorking();
    app.accomodationImageGallery.carouselWorking();
};

$(document).ready(app.init());