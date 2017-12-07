var app = app || {};

app.roomReservation = {

    datePickersWorking: function () {
        $('#datetimepicker1').datetimepicker({format: 'YYYY/MM/DD'});
        $('#datetimepicker1').datetimepicker('setStartDate', '2050/01/01');
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY/MM/DD',
            useCurrent: false
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker2").on("dp.change", function (e) {
            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        });
    },

    carouselWorking: function () {
        /*$('#galleryCarousel').carousel({
            interval: 5000
        });*/

        //Handles the carousel thumbnails
        $('[id^=carousel-selector-]').click(function () {
            var id_selector = $(this).attr("id");
            try {
                var id = /-(\d+)$/.exec(id_selector)[1];
                console.log(id_selector, id);
                jQuery('#galleryCarousel').carousel(parseInt(id));
            } catch (e) {
                console.log('Regex failed!', e);
            }
        });
        // When the carousel slides, auto update the text
        $('#galleryCarousel').on('slid.bs.carousel', function (e) {
            var id = $('.item.active').data('slide-number');
            $('#carousel-text').html($('#slide-content-'+id).html());
        });
    },

    listenRoomSelection: function () {
        $('input[class=room-checkbox]').change(function(){
            var totalBed = $('#total-bed').data("bed");
            var totalPrice = $('#total-price').data("price");
            if($(this).is(':checked')) {
                var bed = $(this).data("bed");
                var newTotalBed = parseInt(totalBed) + parseInt(bed);
                var price = $(this).data("price");
                var newTotalPrice = (parseFloat(totalPrice) + parseFloat(price)).toFixed(1);
            } else {
                var bed = $(this).data("bed");
                var newTotalBed = parseInt(totalBed) - parseInt(bed);
                var price = $(this).data("price");
                var newTotalPrice = (parseFloat(totalPrice) - parseFloat(price)).toFixed(1);
            }
            $("#total-bed").text(String(newTotalBed));
            $("#total-bed").data("bed", String(newTotalBed));
            $("#total-price").text(String(newTotalPrice));
            $("#total-price").data("price", String(newTotalPrice));
        });
    }

};