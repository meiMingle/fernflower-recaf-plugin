# Recaf plugin workspace

This is a plugin for Recaf `4.X` that adds the Fernflower decompiler. 

## How to use it

Once you've downloaded or cloned the repository, you can compile with `gradlew build`.
This will generate the file `build/libs/example-plugin-{VERSION}.jar`. 

To add your plugin to Recaf:

1. Navigate to the `plugins` folder.
    - Windows: `%APPDATA%/Recaf/plugins`
    - Linux: `$HOME/Recaf/plugins`
2. Copy your plugin jar into this folder
3. Run Recaf to verify your plugin loads. 
