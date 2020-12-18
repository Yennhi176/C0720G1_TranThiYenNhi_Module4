$('#btn').click(function () {
    let deposit,total = 0;
    let start = new Date($('#start').val()),
        end = new Date($('#end').val()),
        diff = new Date(end - start),
        days = diff/1000/60/60/24;
    deposit = parseInt($('#deposit').val());
    total = parseInt(days)*300-deposit;
    if (total < 0){
        alert("ngày bắt đầu phải trước ngày kết thúc");
    }else {
        $('#total').val(total)
    }

});