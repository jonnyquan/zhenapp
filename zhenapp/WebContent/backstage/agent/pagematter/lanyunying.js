var Message = Message || {
  info : function(msg, auto_close) {
    if ($('#message').length > 0) {
      $('#message').remove();
    }

    var $target = $('#module-head');
    if ($target.length == 0) {
      $target = $('.module');
    }
    $target.after('<div id="message" style="display: none;"><i class="am-icon-check"></i>' + msg + '</div>');
    $('#message').addClass('am-alert').addClass('am-alert-success').slideDown(300);
    if (auto_close) {
      setTimeout(function() {
        $('#message').slideUp(300);
      }, 2000);
    }
  },
  error : function(msg, auto_close) {
    if ($('#message').length > 0) {
      $('#message').remove();
    }

    var $target = $('#module-head');
    if ($target.length == 0) {
      $target = $('.module');
    }
    $target.after('<div id="message" style="display: none;"><i class="am-icon-close"></i>' + msg + '</div>');
    $('#message').addClass('am-alert').addClass('am-alert-danger').slideDown(300);
    if (auto_close) {
      setTimeout(function() {
        $('#message').slideUp(300);
      }, 2000);
    }
  }
};

