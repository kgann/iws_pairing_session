Autocomplete::Application.routes.draw do
  root :to => 'home#index'
  match '/autocomplete/:word' => 'autocomplete#index'
end
