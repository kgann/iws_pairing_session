class AutoCompleteView
  constructor: ->
    $ =>
      @input = $('#autocomplete input')
      @matches = $('#matches')
      @limit = 3 # wait for limit chars before getting auto complete data
      @bindHandlers()

  bindHandlers: ->
    @input.keyup (e) =>
      @matches.html =>
        if @input.val().length >= @limit
          $.getJSON "/autocomplete/#{@input.val()}", (data) =>
            @matches.html data.matches.join '</br>'
        else null

new AutoCompleteView()