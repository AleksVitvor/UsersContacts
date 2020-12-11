using Front.CustomCommands;
using Front.Models;
using Library.Filters;
using Library.Responces;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Net.Http;
using System.Net.Http.Json;
using System.Runtime.CompilerServices;

namespace Front.ViewModels
{
    public class UserViewModel : INotifyPropertyChanged
    {
        static HttpClient client = new HttpClient();
        private User _selectedCar;
        public ObservableCollection<User> Users { get; set; } = new ObservableCollection<User>();
        public User SelectedUser
        {
            get { return _selectedCar; }
            set
            {
                _selectedCar = value;
                OnPropertyChanged("SelectedUser");
            }
        }

        private RelayCommand removeCommand;
        public RelayCommand RemoveCommand
        {
            get
            {
                return removeCommand ??
                    (removeCommand = new RelayCommand(obj =>
                    {
                        User user = obj as User;
                        if (user != null)
                        {
                            DeleteUserFilter filter = new DeleteUserFilter();
                            filter.UserId = user.Id;
                            client.PostAsJsonAsync("http://localhost:8080/admin/delete", filter);
                        }
                    },
                    (obj) => Users.Count > 0));
            }
        }
        public UserViewModel()
        {
            List<UserInfo> response = client.GetFromJsonAsync<List<UserInfo>>("http://localhost:8080/admin/all").Result;
            foreach(var i in response)
            {
                User user = new User();
                user.Id = i.Id;
                user.Username = i.Username;
                Users.Add(user);
            }
        }
        public event PropertyChangedEventHandler PropertyChanged;
        public void OnPropertyChanged([CallerMemberName] string prop = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(prop));
        }
    }
}
