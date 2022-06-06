#!/usr/bin/env bash

export URL="http://localhost:8080/tasks"

open_browser() {
  if xdg-open $URL; then
    end
  else
    fail
  fi
}

fail() {
  echo "There were errors compilation. Exit!"
}

end() {
  echo "Launching web browser: Done."
}

if ./runcrud.sh; then
  open_browser
else
    fail
fi