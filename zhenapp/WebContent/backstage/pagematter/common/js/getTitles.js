$(function(){
    $('#goodsLink').on('change', function(){
        url = ($(this).val());
        setLongTitle(url);
    });
});

function setLongTitle(url){
    $.post('/ajax/checkGoodUrl', { param: url}, function (data) {

        $('#goodsTitle').val(data.goodsLongTitle);
        $('#goodsSubTitle').val(data.goodsShortTitle);

    })
};