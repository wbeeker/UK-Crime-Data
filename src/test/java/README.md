# Test Files

You should have full code coverage on your tests. 


Creation of the GUI window.
![gui window](imgs/1_create_window.png)

Added window title for the GUI.
![gui window title](imgs/2_add_title.png)

Added a search box.
![search box](imgs/3_add_search_box.png)

Added 'Crime Search' button.
![search button](imgs/4_add_search_button.png)

Added 'Display Map' and 'Display Stats' buttons.
![map stst buttons](imgs/5_add_stats_button.png)

Added action listener for the 'Crime Search' button and a text area ('Crime Search' button prints "Crime" to the text area).
![crime action listener](imgs/6.add_crime_ax_lis.png)

Added action listener for the 'Display Map' button ('Display Map' button prints "Map" to the text area).
![map action listener](imgs/7.add_map_ax_lis.png)

Added action listener for the 'Display Stats' button ('Display Stats' button prints "Stats" to the text area).
![stats action listener](imgs/8.add_stats_ax_lis.png)

Added 'Timeline' button.
![timeline button](imgs/9_add_timeline_button.png)

Added action listener for the 'Timeline' button ('Timeline' button prints "Timeline" to the text area).
![gtimeline action listener](imgs/10.add_timeline_ax_lis.png)

Added Crime Details button.
![details button](imgs/11_add_details_button.png)

Added action listener for the 'Crime Details' button ('Crime Details' button prints "Details" to the text area).
![details action listener](imgs/12.add_details_ax_lis.png)

Added 'Location' button
![location button](imgs/13_add_location_button.png)

Added action listener for the 'Location' button ('Location' button prints "Location Details" to the text area).
![location action listener](imgs/14.add_location_ax_lis.png)

Added 'Crime Info' scroll pane to west and 'Crime Stats' text area to east.
![info stats scrollpanes](imgs/15.png)

Set size of crime info scroll pane and crime stats text area
![set size scroll text stats info](imgs/16.png)

Replaced 'Crime Search' box with dropdown menu.
![dropdown](imgs/17.png)

Added test Crime.java file (to delete later) to visualize how 'Crime Info' is displayed when the 'Crime Search' button is clicked. Updated 'Crime Search' button listener to display the example crimes.
![testing](imgs/18.png)

Updated dropdown to populate the crime categories provided by the API.
![dropdown update](imgs/19.png)

Updated 'Crime Search' button listener to display all the crimes of a chosen category when a category is selected from the dropdown and the 'Crime Search' button is clicked.
![category](imgs/20_update_search_cat_data.png)

Updated 'Crime Stats' listener to add up the total number of crimes after a category is selected and searched when the 'Crime Stats' button is clicked. Displayed in the 'Crime Stats' text area.
![gstats action listener](imgs/21_add_stats_method.png)

Updated 'Crime Stats' listener to add up the total number of crimes per street if there are multiple crimes on a street (does not display single crimes per street). Displayed in the 'Crime Stats' text area. 
![stats action listener](imgs/22_stats_streets.png)

Updated 'Crime Stats' to include a scroll pane.
![stats scrollpane](imgs/23_stats_scrollpane.png)

Added titles to 'Crime Info' and 'Crime Stats' scrollpanes.
![titles](imgs/24_titled_border.png)

Resized overall window and 'Crime Info' and 'Crime Stats' scrollpanes.
![size](imgs/25.png)

Reformatted how the 'Crime Info' is displayed.
![crime info display](imgs/26.png)

Reformatted how the 'Crime Stats' are displayed.
![crime stats display](imgs/27.png)

Added a static google map image of the specific location provided by the API (Leicester: city in England).
![map](imgs/28_add_map.png)

Updated the 'Crime Map' listener to display markers on the map for each crime per category (once searched) when 'Crime Map' is clicked (current category is shoplifting).
![map action listener](imgs/29_add_markers.png)

Adittional map view of bicycle theft markers.
![different map view](imgs/30_add_markers.png)

Added title to the Map.
![map title](imgs/31_add_map_title.png)

Removed unused bottom buttons.
![remove buttons](imgs/32_remove_buttons.png)

Updated bottom button names.
![button names](imgs/33_button_names.png)

Added 'Add Crime' button.
![gadd crime button](imgs/34_add_crime_button.png)

Incorporated sorting alphabetically to category list in dropdown.
![sort dropdown](imgs/35_sort_categories.png)

Added 'List of Crimes' scroll pane to east underneath 'Crime Stats' scroll pane.
![list scroll pane](imgs/36_add_list_pane.png)

Updated title of 'List of Crimes' scroll pane and added 'Add Crime' listener to display text in the 'Crimes Added to List' scroll pane.
![action listeners](imgs/37_add_crime_text.png)

Updated 'Add Crime' listener to add the currently searched category to the list.
![crime action listener](imgs/38_category_list.png)

Added 'Clear List' button and functionality to remove added crimes from 'Crimes Added to List' display.
![clear list buttn](imgs/39_clear_list.png)

Added 'Save Crimes' button and method to save the list of added crimes to a file.
![save crimes](imgs/40_save_button.png)

Reformatted 'Crime Info' display to include crime category. 
![info display](imgs/41_add_cat_info.png)

Added 'Exit' button and functionality.
![exit](imgs/42_add_exit_button.png)

Added 'all crimes' to drop down and updated functionality for it.
![all crimes](imgs/1.png)
