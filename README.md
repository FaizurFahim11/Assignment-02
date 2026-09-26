# Lab02 — User Profile (Java Swing) — NetBeans Project

This folder is a ready-made NetBeans "Java with Ant" project named **Lab02**.

## How to open it
1. Download and unzip `Lab02.zip` somewhere on your computer.
2. In NetBeans: **File > Open Project...**
3. Select the unzipped `Lab02` folder (the one containing `build.xml`
   and the `nbproject` folder) and click **Open Project**.
4. The first time you open it, NetBeans will silently regenerate
   `nbproject/build-impl.xml` (a machine-generated build script) — this is
   normal and expected; it's not included in the zip on purpose.
5. Right-click the project in the **Projects** pane and choose **Run**
   (or press F6). NetBeans will compile and launch the app automatically.

## Folder layout
```
Lab02/
├── build.xml                 (Ant build script — delegates to nbproject/build-impl.xml)
├── manifest.mf                (jar manifest)
├── nbproject/
│   ├── project.xml            (tells NetBeans this is a Java SE project named Lab02)
│   └── project.properties     (source folder, main class, JDK level, etc.)
└── src/
    └── UserProfileApp.java    (the whole application — single file, default package)
```

## Project settings already configured
- Project name (as shown in NetBeans): **Lab02**
- Main class: `UserProfileApp` (the class name itself is unchanged — only the
  project/jar name is Lab02)
- Source/target JDK level: 17 (edit `javac.source` / `javac.target` in
  `nbproject/project.properties` if your installed JDK is older/newer —
  right-click the project → **Properties** → **Sources** does this through the UI too)
- Source folder: `src`

## If NetBeans still won't open it
Rarely, a very old or very new NetBeans version wants project metadata in a
slightly different shape. The safest fallback is:
**File > New Project... > Java with Ant > Java Application**, name it
**Lab02**, uncheck "Create Main Class", finish the wizard, then copy
`src/UserProfileApp.java` into the new project's `src` folder and Run.

## What the app does
See the comments at the top of `UserProfileApp.java` — in short: a Swing
form to create a user profile (name, gender, age, phone, email, optional
photo), with live, event-driven validation on every field, and a bonus
photo-upload/display feature shown together with the profile summary in a
`JOptionPane`.
