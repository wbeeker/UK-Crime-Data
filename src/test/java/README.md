# Test Files

You should have full code coverage on your tests. 


Creation of the GUI window.
![gui window](imgs/1_create_window.png)

Added window title for the GUI.
![gui window title](imgs/2_add_title.png)

Added a search box.
![gui window title](imgs/3_add_search_box.png)

Added Crime Search button.
![gui window title](imgs/4_add_search_button.png)

Added Display Map and Display Stats buttons.
![gui window title](imgs/5_add_stats_button.png)

Added action listener for the Crime Search button and a text area (Crime Search button prints "Crime" to the text area).
![gui window title](imgs/6.add_crime_ax_lis.png)

Added action listener for the Display Map button (Display Map button prints "Map" to the text area).
![gui window title](imgs/7.add_map_ax_lis.png)

Added action listener for the Display Stats button (Display Stats button prints "Stats" to the text area).
![gui window title](imgs/8.add_stats_ax_lis.png)

Added Timeline button.
![gui window title](imgs/9_add_timeline_button.png)

Added action listener for the Timeline button (Timeline button prints "Timeline" to the text area).
![gui window title](imgs/10.add_timeline_ax_lis.png)

Added Crime Details button.
![gui window title](imgs/11_add_details_button.png)

Added action listener for the Crime Details button (Crime Details button prints "Details" to the text area).
![gui window title](imgs/12.add_details_ax_lis.png)

Added Location button
![gui window title](imgs/13_add_location_button.png)

Added action listener for the Location button (Location button prints "Location Details" to the text area).
![gui window title](imgs/14.add_location_ax_lis.png)

Added Crime Info scroll pane to west and Crime Stats text area to east.
![gui window title](imgs/15.png)

Set size of crime info scroll pane and crime stats text area
![gui window title](imgs/16.png)

Replaced Crime Search box with dropdown menu.
![gui window title](imgs/17.png)

Added test Crime.java file (to delete later) to visualize how Crime Info is displayed when the Crime Search Button is clicked. Updated Crime Search button listener to display the example crimes.
![gui window title](imgs/18.png)

Updated dropdown to populate the crime categories provided by the API.
![gui window title](imgs/19.png)

Updated Crime Search button listener to display all the crimes of a chosen category when a category is selected from the dropdown and the Crime Search Button is clicked.
![gui window title](imgs/20_update_search_cat_data.png)

Updated Crime Stats listener to add up the total number of crimes after a categry is selected and searched when the Crime Stats button is clicked. Displayed in the Crime Stats text area.
![gui window title](imgs/21_add_stats_method.png)

Updated Crime Stats listener to add up the total number of crimes per street if there are multiple crimes on a street (does not display single crimes per street). Displayed in the Crime Stats text area. 
![gui window title](imgs/22_stats_streets.png)

Updated Crime Stats to include a scroll pane.
![gui window title](imgs/23_stats_scrollpane.png)

Added titles to Crime Info and Crime Stats scrollpanes.
![gui window title](imgs/24_titled_border.png)

Resized overall window and Crime Info and Crime Stats scrollpanes.
![gui window title](imgs/25.png)

Reformatted how the Crime Info is displayed.
![gui window title](imgs/26.png)

Reformatted how the Crime Stats are displayed.
![gui window title](imgs/27.png)

Added a static google map image of the specific location provided by the API (Leicester: city in England).
![gui window title](imgs/28_add_map.png)

Updated the Crime Map listener to display markers on the map for each crime per category (once searched) when Crime Map is clicked (current category is shoplifting).
![gui window title](imgs/29_add_markers.png)

View of bicycle theft markers.
![gui window title](imgs/30_add_markers.png)

Added title to the Map.
![gui window title](imgs/31_add_map_title.png)

Removed unused bottom buttons.
![gui window title](imgs/32_remove_buttons.png)

Updated bottom button names.
![gui window title](imgs/33_button_names.png)

Added Add Crime button.
![gui window title](imgs/34_add_crime_button.png)

Incorporated sorting alphabetically to category list in dropdown.
![gui window title](imgs/35_sort_categories.png)

Added List of Crimes scroll pane to east underneath Crime Stats scroll pane.
![gui window title](imgs/36_add_list_pane.png)

Updated title of List of Crimes scroll pane and added Add Crime listener to display text in the Crimes Added to List scroll pane.
![gui window title](imgs/37_add_crime_text.png)

Updated Add Crime listener to add the currently searched category toa list and display crime category in Crimes Added to List scroll pane.
![gui window title](imgs/38_category_list.png)

Added Clear List button and functionality to remove added crimes from Crimes Added to List display.
![gui window title](imgs/39_clear_list.png)

Added Save Crimes button and method to save the list of added crimes to a file.
![gui window title](imgs/40_save_button.png)

Reformatted Crime Info display to show the crime Category to visualize easier that the crimes are updated when a new crime is selectd and searched.
![gui window title](imgs/41_add_cat_info.png)

Added exit button and functionality.
![gui window title](imgs/42_add_exit_button.png)
