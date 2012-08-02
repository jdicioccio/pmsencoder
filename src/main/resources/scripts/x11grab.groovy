// videostream.Web,Screen=Screen,x11grab://

script {
    profile ('x11grab://') {
        pattern {
            match { !pms.isWindows() }
            match uri: '^x11grab://(?<display>.*)$'
        }

        action {
            if (!display) {
                display = ':0.0'
            }
            uri = display
            set '-f': 'x11grab'
            // these need to be configurable via the URI
            set '-s': '1024x768'
            set '-r': 25
        }
    }
}
