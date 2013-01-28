require 'net/http'
require 'uri'

class AutocompleteController < ApplicationController
  def index
    uri = URI.parse("http://localhost:3001/#{params[:word]}")
    render :json => Net::HTTP.get_response(uri).body
  end
end