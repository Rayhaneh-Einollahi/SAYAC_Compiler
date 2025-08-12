import os

tests_dir = "tests"
output_dir = ".idea/runConfigurations"
module_name = "SAYAC_Compiler"  # change if needed
main_class = "SimpleLang"       # change if needed

os.makedirs(output_dir, exist_ok=True)

for root, _, files in os.walk(tests_dir):
    for file in files:
        if file.endswith(".c"):
            rel_path = os.path.join(root, file).replace("\\", "/")
            folder_name = os.path.basename(root)
            config_name = f"{folder_name}_{file}"  # now includes folder name
            xml_content = f"""<component name="ProjectRunConfigurationManager">
  <configuration name="{config_name}" type="Application" factoryName="Application">
    <option name="MAIN_CLASS_NAME" value="{main_class}" />
    <module name="{module_name}" />
    <option name="PROGRAM_PARAMETERS" value="{rel_path}" />
    <method v="2">
      <option name="Make" enabled="true" />
    </method>
  </configuration>
</component>"""
            with open(os.path.join(output_dir, f"{config_name}.xml"), "w", encoding="utf-8") as f:
                f.write(xml_content)

print("Run configurations created!")
