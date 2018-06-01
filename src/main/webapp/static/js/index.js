/**
 * Created by 武海升 on 2018-05-31.
 */
function executeJob() {
    $.ajax({
        url: 'executeJob',
        type: 'POST',
        success: function (resunlt) {
            if(resunlt==true){
                swal({
                        title: "执行Job任务",
                        text: "执行Job任务成功",
                        type: "success",
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定!",
                        closeOnConfirm: false
                    },
                    function(){
                        window.location.href = ""
                    });
            }
        }
    });
}

function pauseJob() {
    $.ajax({
        url: 'pauseJob',
        type: 'POST',
        success: function (resunlt) {
            if(resunlt==true){
                swal({
                        title: "暂停Job任务",
                        text: "暂停Job任务成功",
                        type: "success",
                        confirmButtonColor: "#DD6B55",
                        confirmButtonText: "确定!",
                        closeOnConfirm: false
                    },
                    function(){
                        window.location.href = "?pauseJob=pauseJob"
                    });
            }
        }
    });
}

function updateJob() {
    swal({
            title: "修改Job任务",
            text: "修改Job任务运行时间",
            type: "input",
            showCancelButton:true,
            closeOnConfirm:false,
            confirmButtonText:"确认",
            cancelButtonText:"取消",
            animation: "slide-from-top",
            inputPlaceholder: "输入Corn时间表达式"
        },
        function (inputValue){
            if(inputValue){
                var cronValidateResult = cronValidate(inputValue);
                console.log(cronValidateResult);
                if(cronValidateResult==true){
                    $.ajax({
                        url: 'updateJob',
                        type: 'POST',
                        data : {
                            cronExpression : inputValue
                        },
                        success: function (resunlt) {
                            if(resunlt==true){
                                swal({
                                        title: "修改Job任务",
                                        text: "修改Job任务成功",
                                        type: "success",
                                        confirmButtonColor: "#DD6B55",
                                        confirmButtonText: "确定!",
                                        closeOnConfirm: false
                                    },
                                    function(){
                                        window.location.href = ""
                                    });
                            }
                        }
                    });
                }else{
                    swal(cronValidateResult);
                }
            }else{
                swal("输入不能为空");
            }
        }
    );
}


