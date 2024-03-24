$(document).ready(function() {
    $('#enrollmentForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            studentCode: $('#studentCode').val(),
            courseCode: $('#courseCode').val(),
            mileageBet: $('#mileageBet').val()
        };
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: '/enrollments',
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(enrollment) {
                // 등록 성공 시 처리
                alert('등록이 완료되었습니다.');
                // 필요에 따라 추가적인 처리를 수행할 수 있습니다.
            },
            error: function(xhr, status, error) {
                // 등록 실패 시 처리
                alert('등록에 실패하였습니다.');
                console.error(xhr.responseText);
            }
        });
    });
});

$(document).ready(function() {
    // 페이지가 로드되면 수강신청 결과를 조회합니다.
    $.get('/completed-enrollments', function(enrollments) {
        var enrollmentsBody = $('#enrollmentsBody');
        enrollments.forEach(function(enrollment) {
            var row = $('<tr>');
            row.append($('<td>').text(enrollment.studentCode));
            row.append($('<td>').text(enrollment.courseCode));
            row.append($('<td>').text(enrollment.mileageBet));
            enrollmentsBody.append(row);
        });
    });
});
