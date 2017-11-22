var app = app || {};

app.datePicker = {

    datePickersWorking: function () {
        $('#datetimepicker1').datetimepicker({format: 'YYYY/MM/DD'});
        $('#datetimepicker1').datetimepicker('setStartDate', '2050/01/01');
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY/MM/DD',
            useCurrent: false //Important! See issue #1075
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker2").on("dp.change", function (e) {
            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        });
    }

};